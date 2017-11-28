public class Levenshtein {
	/**
	 * Odleglosc Levenshteina (odleglosc edycyjna)
	 */
	public static int levenshtein(String s, String t)
	{
	   int i, j, m, n, cost;
	   int d[][];

	   m = s.length();
	   n = t.length();
	   
	   d = new int[m+1][n+1];

	   for (i=0; i<=m; i++)
	      d[i][0] = i;
	   for (j=1; j<=n; j++)
	      d[0][j] = j;

	   for (i=1; i<=m; i++)
	   {
	      for (j=1; j<=n; j++)
	      {
	           if (s.charAt(i-1) == t.charAt(j-1))
	              cost = 0;
	           else
	              cost = 1;

	           d[i][j] = Math.min(d[i-1][j] + 1,         /* remove */
	                        Math.min(d[i][j-1] + 1,      /* insert */
	                             d[i-1][j-1] + cost));   /* change */
	      }
	   }
	   return d[m][n];
	}
	public static int levenshteinDistance (CharSequence lhs, CharSequence rhs) {
		int len0 = lhs.length() + 1;
		int len1 = rhs.length() + 1;

		// the array of distances
		int[] cost = new int[len0];
		int[] newcost = new int[len0];

		// initial cost of skipping prefix in String s0
		for (int i = 0; i < len0; i++) cost[i] = i;

		// dynamically computing the array of distances

		// transformation cost for each letter in s1
		for (int j = 1; j < len1; j++) {
			// initial cost of skipping prefix in String s1
			newcost[0] = j;

			// transformation cost for each letter in s0
			for(int i = 1; i < len0; i++) {
				// matching current letters in both strings
				int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

				// computing cost for each transformation
				int cost_replace = cost[i - 1] + match;
				int cost_insert  = cost[i] + 1;
				int cost_delete  = newcost[i - 1] + 1;

				// keep minimum cost
				newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
			}

			// swap cost/newcost arrays
			int[] swap = cost; cost = newcost; newcost = swap;
		}

		// the distance is the cost for transforming all letters in both strings
		return cost[len0 - 1];
	}

}
