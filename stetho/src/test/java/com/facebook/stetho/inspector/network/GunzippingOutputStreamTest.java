/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.stetho.inspector.network;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class GunzippingOutputStreamTest {
  @Test(timeout = 1000)
  public void testGunzip() throws IOException {
    byte[] data = "test123test123".getBytes();

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    OutputStream unzippingStream = GunzippingOutputStream.create(out);
    OutputStream zippingStream = new GZIPOutputStream(unzippingStream);
    zippingStream.write(data);
    zippingStream.close();
    assertArrayEquals(data, out.toByteArray());
  }
}
