package com.example.administrator.penghuidemo.takephoto.model;

import java.io.Serializable;

/**
 * Author: crazycodeboy
 * Date: 2016/11/5 0007 20:10
 * Version:4.0.0
 * 技术博文：http://www.devio.org/
 * GitHub:https://github.com/crazycodeboy
 * Eamil:crazycodeboy@gmail.com
 */
public class TakePhotoOptions implements Serializable {
    /**
     * 是否使用TakePhoto自带的相册进行图片选择，默认不使用，但选择多张图片会使用
     */
    private boolean withOwnGallery;

    private TakePhotoOptions() {
    }

    public boolean isWithOwnGallery() {
        return withOwnGallery;
    }

    public void setWithOwnGallery(boolean withOwnGallery) {
        this.withOwnGallery = withOwnGallery;
    }

    public static class Builder {
        private TakePhotoOptions options;

        public Builder() {
            this.options = new TakePhotoOptions();
        }

        public Builder setWithOwnGallery(boolean withOwnGallery) {
            options.setWithOwnGallery(withOwnGallery);
            return this;
        }
        public TakePhotoOptions create(){
            return options;
        }
    }
}
