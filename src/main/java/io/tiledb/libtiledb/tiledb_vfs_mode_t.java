/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.tiledb.libtiledb;

public enum tiledb_vfs_mode_t {
  TILEDB_VFS_READ(0),
  TILEDB_VFS_WRITE(1),
  TILEDB_VFS_APPEND(2);

  public final int swigValue() {
    return swigValue;
  }

  public static tiledb_vfs_mode_t swigToEnum(int swigValue) {
    tiledb_vfs_mode_t[] swigValues = tiledb_vfs_mode_t.class.getEnumConstants();
    if (swigValue < swigValues.length
        && swigValue >= 0
        && swigValues[swigValue].swigValue == swigValue) return swigValues[swigValue];
    for (tiledb_vfs_mode_t swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue) return swigEnum;
    throw new IllegalArgumentException(
        "No enum " + tiledb_vfs_mode_t.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private tiledb_vfs_mode_t() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private tiledb_vfs_mode_t(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue + 1;
  }

  @SuppressWarnings("unused")
  private tiledb_vfs_mode_t(tiledb_vfs_mode_t swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue + 1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}
