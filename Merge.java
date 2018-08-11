class Merge {

	public static void main(String[] args) {
		int[] a = { 10, 20, 15, 30, 80};
		int[] b = { 90, 40, 76, 90, 180, 150 };
		int n1 = a.length;
		int n2 = b.length;
		int[] c = new int[n1 + n2];
		merge(a, b, c, n1, n2);
		System.out.print("Merge Array: ");
		/*for (int i = 0; i < n1 + n2; i++)
			System.out.print(c[i] + " ");*/
              

               for(int k=0;k<c.length-1;k++){
        for(int i=0;i<c.length-k-1;i++){
            if(c[i]>c[i+1]){
                int temp=c[i];
                c[i]=c[i+1];
                c[i+1]=temp;
            }
        }
    }

    for (int i = 0; i < n1 + n2; i++)
	System.out.print(c[i] + " ");



 

       
	}

       public static void merge(int[] a, int[] b, int[] c, int n1, int n2) {
		int i = 0, j = 0, k = 0;
		while (i < n1 && j < n2) {
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		while (i < n1)
			c[k++] = a[i++];
		while (j < n2)
			c[k++] = b[j++];
	}

}
