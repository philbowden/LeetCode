class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int maxCitations = 0;
        for (int i = 0; i < n; i++) {
            int val = citations[i];
            int numCitationsGreaterOrEqualToVal = n-i;
            if (numCitationsGreaterOrEqualToVal <= val) {
                maxCitations = Math.max(maxCitations, numCitationsGreaterOrEqualToVal);
            }
        }
        return maxCitations;
    }
}

