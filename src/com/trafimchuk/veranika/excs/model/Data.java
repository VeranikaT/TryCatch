package com.trafimchuk.veranika.excs.model;

import java.util.Objects;

public class Data {

    private Sign sign;
    private Number x;
    private Number y;
    private Number res;

    public Data() {

    }

    public Data(Number x, Number y, Sign sign, Number res) {
        this.x = x;
        this.y = y;
        this.sign = sign;
        this.res = res;
    }

    public Number getX() {
        return x;
    }

    public void setX(Number x) {
        this.x = x;
    }

    public Number getY() {
        return y;
    }

    public void setY(Number y) {
        this.y = y;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public Number getRes() { return res; }

    public void setRes(Number res) { this.res = res; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return sign == data.sign && Objects.equals(x, data.x) && Objects.equals(y, data.y) && Objects.equals(res, data.res);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign, x, y, res);
    }

    @Override
    public String toString() {
        return "Data{" +
                "sign=" + sign +
                ", x=" + x +
                ", y=" + y +
                ", res=" + res +
                '}';
    }
}
