// Time Complexity : O(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Divide Number into Chunks: The code processes the number in chunks of three digits (thousands, millions, billions), appending the appropriate scale ("Thousand", "Million", "Billion") to the result.
//Convert Chunks to Words: It uses a recursive helper function to convert each three-digit chunk into words by breaking them down further into hundreds, tens, and units.
//Assemble the Result: The main function assembles these word chunks together into the final result, ensuring that spaces are managed correctly and leading/trailing spaces are trimmed.

class Solution {
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result = recurse(num % 1000) + thousands[i] + " " + result;
            }
            i++;
            num = num / 1000;
        }
        return result.trim();
    }

    private String recurse(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return below_20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + recurse(num % 10);
        } else {
            return below_20[num / 100] + " Hundred " + recurse(num % 100);
        }
    }
}
