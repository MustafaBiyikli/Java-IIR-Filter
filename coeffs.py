'''
File: coeffs.py
Project: Java-IIR-Filter
File Created: Monday, 16 November 2020 @ 1:51:50 pm
Author: Mustafa Biyikli (biyiklimustafa96@gmail.com)
-----
Last Modified: Thursday, 10 December 2020 @ 11:48:30 am
Modified By: Mustafa Biyikli (biyiklimustafa96@gmail.com>)
-----
License MIT License (http://www.opensource.org/licenses/mit-license.php)
Copyright (c) 2020 Mustafa Biyikli
'''

"""
Author: Mustafa Biyikli
Outputs the SOS coefficients required by the Java IIR Filter class
"""

import scipy.signal as signal

# fs -> sampling rate [Hz]
# f1, f2 -> cut off frequencies [Hz]
# order -> filter order [Hz]

def lowPass(fs, f1, order=4):
    return signal.butter(order, [f1/fs*2], "low", output="sos")

def highPass(fs, f1, order=4):
    return signal.butter(order, [f1/fs*2], "high", output="sos")

def bandPass(fs, f1, f2, order=4):
    return signal.butter(order, [f1/fs*2, f2/fs*2], "bandpass", output="sos")

def bandStop(fs, f1, f2, order=4):
    return signal.butter(order, [f1/fs*2, f2/fs*2], "bandstop", output="sos")
