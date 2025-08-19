class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if(str.charAt(0) != '-'){
            for(int i = str.length() - 1; i >=0; i--){
                sb.append(str.charAt(i));
            }
        }else{
            sb.append(str.charAt(0));
            for(int i = str.length() - 1; i >=1; i--){
                sb.append(str.charAt(i));
            }
        }
        try {
            return Integer.parseInt(sb.toString());  // May throw exception
        } catch (NumberFormatException e) {
            return 0;  // If overflow, return 0
        }
    }
}