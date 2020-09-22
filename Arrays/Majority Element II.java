class Solution {
    public List<Integer> majorityElement(int[] nums) {
        var result = new ArrayList<Integer>(2);
        var max = nums.length / 3;

        Integer cand1 = null, cand2 = null;
        int confidence1 = 0, confidence2 = 0;

        for (var num : nums) {
            if (cand1 != null && num == cand1) {
                ++confidence1;
            } 
            else if (cand2 != null && num == cand2) {
                ++confidence2;
            } 
            else if (confidence1 == 0) {
                cand1 = num;
                ++confidence1;
            }
            else if (confidence2 == 0) {
                cand2 = num;
                ++confidence2;
            }
            else {
                --confidence1;
                --confidence2;
            }
        }

        confidence1 = 0;
        confidence2 = 0;

        for (var num : nums) {
            if (cand1 != null && num == cand1) ++confidence1;
            if (cand2 != null && num == cand2) ++confidence2;
        }

        if (confidence1 > max) {
            result.add(cand1);
        }

        if (confidence2 > max) {
            result.add(cand2);
        }

        return result;
    }
}