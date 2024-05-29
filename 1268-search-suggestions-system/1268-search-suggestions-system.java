class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        int n = searchWord.length();
        Arrays.sort(products);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(searchWord.charAt(i));
            List<String> list = new ArrayList<>();
            for (int j = 0; j < products.length; j++) {
                String subS = sb.toString();
                String product = products[j];
                boolean isMatch = true;
                int idx = 0;
                while (idx < subS.length() && isMatch) {
                    if (idx >= product.length()) {
                        isMatch = false;
                        break;
                    }
                    char searchChar = subS.charAt(idx);
                    char prodChar = product.charAt(idx);
                    if (searchChar != prodChar) {
                        isMatch = false;
                    }
                    ++idx;
                }
                if (isMatch) list.add(product);
                if (list.size() == 3) break;
            }
            res.add(list);
        }
        return res;
    }
}
