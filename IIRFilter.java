/*
 * File: IIRFilter.java
 * Project: Java-IIR-Filter
 * File Created: Monday, 16 November 2020 @ 2:24:34 pm
 * Author: Mustafa Biyikli (biyiklimustafa96@gmail.com)
 * -----
 * Last Modified: Thursday, 10 December 2020 @ 11:49:11 am
 * Modified By: Mustafa Biyikli (biyiklimustafa96@gmail.com>)
 * -----
 * License MIT License (http://www.opensource.org/licenses/mit-license.php)
 * Copyright (c) 2020 Mustafa Biyikli
 */

import java.util.ArrayList;
import java.util.List;

class IIRFilter {
    private List<IIR2Filter> slaves = new ArrayList<>();
    private int order;

    void set_sos_coefficients(List<List<Float>> sos_coefficients) {
        order = sos_coefficients.size();
        for (int i = 0; i < order; i++) {
            slaves.add(i, new IIR2Filter());
            slaves.get(i).set_sos_coefficients(sos_coefficients.get(i));
        }
    }

    float doFilter(float data) {
        float output = data;
        for (int i=0; i<order; i++) {
            output = slaves.get(i).doFilter(output);
        }
        return output;
    }
}
