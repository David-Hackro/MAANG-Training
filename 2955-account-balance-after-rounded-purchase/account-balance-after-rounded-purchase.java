class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int mod = purchaseAmount % 10;

        return  mod >= 5 ? 100 - ((purchaseAmount - (mod)) + 10): 100 - (purchaseAmount - (mod));        
    }
}