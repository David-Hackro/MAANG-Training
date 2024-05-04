class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int x = 0;
        int y = 0;

        for(int i = 0; i < Math.max(a.length, b.length); i++) {
            x = i < a.length?Integer.parseInt(a[i]):0;
            y = i < b.length?Integer.parseInt(b[i]):0;
            
            if(x != y) {
                return x > y ?1:-1;
            }
        }

        return 0;
    }
}