package com.example.leecode.demo.runner.value.bit.base10.increase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "bitBase10Increase")
public class BitBase10IncreaseRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        int n = 3;
        IncreasePrinter ip = new IncreasePrinter();
        ip.print(n);
        System.out.println("complete");
    }

    class IncreasePrinter{

        void print(int n){
            int[] value = new int[n];

            while (!increase(value)){
                print(value);
            }
        }

        boolean increase(int[] value){
            boolean isOverflow = false;

            if (value[0]==9){
                boolean carryFlag = true;
                for (int i=1;i<value.length;i++){
                    if (carryFlag){
                        if (value[i]==9){
                            if (i == value.length-1){
                                isOverflow = true;
                                break;
                            }
                            value[i]=0;
                        }else {
                            value[i]++;
                            carryFlag = false;
                        }
                    }else {
                        break;
                    }
                }
                value[0] = 0;
            }else {
                value[0]++;
            }
            return isOverflow;
        }

        void print(int[] value){
            StringBuffer sb = new StringBuffer();
            boolean highZero = true;
            for (int i = value.length-1;i>=0;i--){
                if (highZero){
                    if(value[i]==0){
                        continue;
                    }else {
                        sb.append(value[i]);
                        highZero = false;
                    }
                }else {
                    sb.append(value[i]);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
