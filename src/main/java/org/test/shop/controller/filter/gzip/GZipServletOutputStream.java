/*
 * 
 */
package org.test.shop.controller.filter.gzip;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.io.OutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class GZipServletOutputStream.
 */
class GZipServletOutputStream extends ServletOutputStream {
    
    /** The stream. */
    private OutputStream stream;

    /**
     * Instantiates a new g zip servlet output stream.
     *
     * @param output the output
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public GZipServletOutputStream(OutputStream output)
            throws IOException {
        super();
        this.stream = output;
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#close()
     */
    @Override
    public void close() throws IOException {
        this.stream.close();
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#flush()
     */
    @Override
    public void flush() throws IOException {
        this.stream.flush();
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#write(byte[])
     */
    @Override
    public void write(byte b[]) throws IOException {
        this.stream.write(b);
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#write(byte[], int, int)
     */
    @Override
    public void write(byte b[], int off, int len) throws IOException {
        this.stream.write(b, off, len);
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#write(int)
     */
    @Override
    public void write(int b) throws IOException {
        this.stream.write(b);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletOutputStream#isReady()
     */
    @Override
    public boolean isReady() {
        return true;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletOutputStream#setWriteListener(javax.servlet.WriteListener)
     */
    @Override
    public void setWriteListener(WriteListener listener) {

    }
}
