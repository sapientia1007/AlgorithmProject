import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int minPackagePrice = Integer.MAX_VALUE;
        int minSinglePrice = Integer.MAX_VALUE;

        String inpt = br.readLine();
        int N = Integer.parseInt(inpt.split(" ")[0]); // 끊어진 기타줄 개수
        int M = Integer.parseInt(inpt.split(" ")[1]); // 기타줄 브랜드

        for (int i=0; i<M; i++) {
            // 6개 패키지 가격과 낱개의 가격
            String packageInpt = br.readLine();
            int packagePrice = Integer.parseInt(packageInpt.split(" ")[0]);
            int singlePrice = Integer.parseInt(packageInpt.split(" ")[1]);

            // 각 최소 비용 
            minPackagePrice = Math.min(minPackagePrice, packagePrice);
            minSinglePrice = Math.min(minSinglePrice, singlePrice);
        }
        
        // 비용 계산
        int onlyPackage = ((N/6) + 1) * minPackagePrice;
        int onlySingle = N * minSinglePrice;
        int mixed = (N/6) * minPackagePrice + (N%6) * minSinglePrice;

        // 최소 비용 구하기 
        int minCost = Math.min(onlyPackage, Math.min(onlySingle, mixed));

        System.out.println(minCost);
        br.close();
    }
}
