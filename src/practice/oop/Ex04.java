package practice.oop;

public class Ex04 {
    public static void main(String[] args) {
        Dog dog = new Dog("小白", 99);
        dog.showInfo();
        dog.eatBone();
    }

    /**
     * 子犬クラス
     * 属性：名前、年齢。年齢は0～15の範囲
     * 行動：骨を食べる
     */
    static class Dog {
        private String name;
        private int age;

        public Dog(String name, int age) {
            this.name = name;
            // 年齢の範囲チェック 0～15、範囲外なら0
            if (age >= 0 && age <= 15) {
                this.age = age;
            } else {
                System.out.println("年齢は 0～15 歳の範囲で指定してください。");
            }
        }

        /**
         * 子犬の情報を出力
         */
        public void showInfo() {
            System.out.println(name + "、" + age + "歳");
        }

        /**
         * 骨を食べる行動
         */
        public void eatBone() {
            System.out.println(age + "歳の" + name + "、骨を食べています");
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
