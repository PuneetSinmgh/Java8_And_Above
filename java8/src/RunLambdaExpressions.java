package java8.src;

public class RunLambdaExpressions {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                for(int i =0 ;i <20; i++){
                    System.out.println("print num : "+ i);
                }
            }
        };

        Runnable  run2 = () -> {

            for (int i = 20; i < 30; i++) {
                System.out.println("print num : " + i);
            }
        };
        new Thread(runnable).start();
        new Thread(run2).start();

        new Thread( () -> {
            for (int i = 20; i < 30; i++) {
                System.out.println("print num : " + i);
            }
        }).start();

    }


}
