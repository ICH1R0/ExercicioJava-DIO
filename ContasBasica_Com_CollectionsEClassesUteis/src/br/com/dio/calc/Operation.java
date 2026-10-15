package br.com.dio.calc;

import java.util.stream.LongStream;

public enum Operation {

    SUM(n -> LongStream.of(n).reduce(0,Long::sum), "+"),
    SUBTRACTION(n -> LongStream.of(n).reduce(0, (n1, n2) -> n1 - n2), "-");

    private final Calc operationCallBack;
    private final String signal;

    Operation(Calc operationCallBack, String signal) {
        this.operationCallBack = operationCallBack;
        this.signal = signal;
    }

    public Calc getOperationCallBack() {
        return operationCallBack;
    }

    public String getSignal() {
        return signal;
    }
}
