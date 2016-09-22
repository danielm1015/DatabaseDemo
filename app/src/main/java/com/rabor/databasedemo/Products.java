/*
 * Copyright (c) 2016. All Rights Reserved.
 */

package com.rabor.databasedemo;

public class Products {

    private int _id;
    private String productname;

    // default constructor
    public Products() {

    }

    public Products(String productname) {
        this.productname = productname;
    }

    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return productname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productname(String productname) {
        this.productname = productname;
    }

}