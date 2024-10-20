package bmi;
public class Calculator {

    public static double bodyMassIndexFormula(double weight, double height, boolean isMetric) {
        if (isMetric) {
            return weight / (height * height);  // BMI = Weight(kg)/[Height(m)]^2
        } else {
            return 703 * (weight / (height * height));  // BMI = 703 * Weight(lbs)/[Height(inches)]^2
        }
    }


    //    BMI VALUES
    //    Underweight:	less than 18.5
    //    Normal:	between 18.5 and 24.9
    //    Overweight:	between 25 and 29.9
    //    Obese:	30 or greater

    public static String statusBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else if (bmi >= 30) {
            return "Obese";
        } else {
            return "";
        }
    }
}