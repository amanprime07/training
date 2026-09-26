package com.training.util;

public class BinaryConverter {
    long bits;

    BinaryConverter(long bits) {
        this.bits = bits;
    }

    public static void main(String[] args) {
        var converter = new BinaryConverter(64);
        System.out.println(converter.convertToBinary(7));
    }

    String convertToBinary(long number) {
        StringBuilder str = new StringBuilder();
        var mask = 1L;
        mask = mask << bits - 1;
        int spacer = 0;
        for (; mask != 0L; mask >>>= 1) {
            if ((number & mask) != 0) {
                str.append("1");
            } else {
                str.append("0");
            }
            if (spacer == 8) {
                str.append(" ");
                spacer = 0;
            }
            spacer++;
        }
        return str.toString();
    }
}
