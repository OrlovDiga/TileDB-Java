/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 TileDB, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @section DESCRIPTION
 *
 * It shows how to read from a sparse array, constraining the read
 * to a specific subarray and a subset of attributes. Moreover, the
 * program shows how to handle incomplete queries that did not complete
 * because the input buffers were not big enough to hold the entire
 * result.
 *
 * You need to run the following to make it work:
 *
 * SparseCreate
 * SparseWriteGlobal1
 * SparseReadSubsetIncomplete
 */

package examples.io.tiledb.java.api;

import io.tiledb.java.api.*;
import io.tiledb.libtiledb.tiledb;
import io.tiledb.libtiledb.tiledb_layout_t;
import io.tiledb.libtiledb.tiledb_query_type_t;

import java.util.Arrays;
import java.util.HashMap;

public class SparseReadSubsetIncomplete {
  public static void main(String[] args) throws Exception {
    // Create TileDB context
    Context ctx = new Context();

    Array my_sparse_array = new Array(ctx, "my_sparse_array");

    // Create query
    Query query = new Query(my_sparse_array, tiledb_query_type_t.TILEDB_READ);
    query.setLayout(tiledb_layout_t.TILEDB_COL_MAJOR);
    query.setSubarray(new NativeArray(ctx, new long[]{3l, 4l, 2l, 4l}, Long.class));
    query.setBuffer("a1", new NativeArray(ctx, 2,Integer.class));

    // Loop until the query is completed

    System.out.println("a1\n---");
    do {
      System.out.println("Reading cells...");
      query.submit();

      int[] a1_buff = (int[]) query.getBuffer("a1");
      for (int i =0; i< a1_buff.length; i++){
        System.out.println(a1_buff[i]);
      }
    } while (query.getQueryStatus() == Status.INCOMPLETE);
  }
}
