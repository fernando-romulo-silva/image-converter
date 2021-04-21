package org.imageconverter;

import java.text.MessageFormat;

import org.springframework.web.multipart.MultipartFile;

public final class Image {

    public final MultipartFile data;

    public final int x;

    public final int y;

    public final int width;

    public final int height;

    public Image(final MultipartFile data, final int x, final int y, final int width, final int height) {
	this.data = data;
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
    }

    public Image(final MultipartFile data) {
	this(data, 0, 0, 0, 0);
    }

    @Override
    public String toString() {
	return MessageFormat.format("Image[file {0}, x {1}, x {2}, width {3}, height {4}]", data.getOriginalFilename(), x, y, width, height);
    }
}
