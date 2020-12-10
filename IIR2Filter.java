/*
 * File: IIR2Filter.java
 * Project: Java-IIR-Filter
 * File Created: Monday, 16 November 2020 @ 2:24:34 pm
 * Author: Mustafa Biyikli (biyiklimustafa96@gmail.com)
 * -----
 * Last Modified: Thursday, 10 December 2020 @ 11:49:26 am
 * Modified By: Mustafa Biyikli (biyiklimustafa96@gmail.com>)
 * -----
 * License MIT License (http://www.opensource.org/licenses/mit-license.php)
 * Copyright (c) 2020 Mustafa Biyikli
 */

import java.util.List;

public class IIR2Filter {
    // FIR coefficients
    private float b0;
    private float b1;
    private float b2;
    // IIR coefficients
    private float a0;
    private float a1;
    private float a2;
    private float buffer1 = 0;
    private float buffer2 = 0;

    void set_sos_coefficients(List<Float> sos) {
        b0 = sos.get(0); b1 = sos.get(1); b2 = sos.get(2);
        a0 = sos.get(3); a1 = sos.get(4); a2 = sos.get(5);
    }

    float doFilter(float data) {
        float acc_input = data - (buffer1*a1) - (buffer2*a2);
        float acc_output = (acc_input*b0) + (buffer1*b1) + (buffer2*b2);

        buffer2 = buffer1;
        buffer1 = acc_input;

        return acc_output;
    }
}
