package calculator;

public class Calculator {
    public enum BiOperatorModes {
        NORMAL, ADD, MINUS, MULTIPLY, DIVIDE
    }

    public enum MonoOperatorModes {
        SQUARE, SQUAREROOT, ONEDIVIDEDBY, COS, SIN, TAN
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.NORMAL;

    private Double calculateBiImpl() {
    	switch (mode) {
    		case NORMAL:
    			return num2;
    			
    		case ADD:
    			return num1 + num2;
    			
    		case MINUS:
    			return num1 - num2;
    			
    		case MULTIPLY:
    			return num1 * num2;
    			
    		case DIVIDE:
    			return num1 / num2;
    		// never reach
    		default: throw new Error();
    	}
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.NORMAL) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return Double.NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.NORMAL, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.NORMAL;

        return Double.NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
    	switch (newMode) {
    		case SQUARE:
    			return num * num;
    			
    		case SQUAREROOT:
    			return Math.sqrt(num);
    			
    		case ONEDIVIDEDBY:
    			return 1 / num;
    			
    		case COS:
    			return Math.cos(num);
    			
    		case SIN:
    			return Math.sin(num);
    			
    		case TAN:
    			return Math.tan(num);
    		// never reach	
    		default: throw new Error();
    	}
    }

}

