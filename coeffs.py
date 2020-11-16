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
