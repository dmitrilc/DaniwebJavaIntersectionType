package com.example;

public class Entry {
    public static void main(String[] args){
        var werewolf = new HumanWolf(){
            @Override
            public void howl() {
                System.out.println("howls");
            }

            @Override
            public void talk() {
                System.out.println("talks");
            }
        };

        boilerplate(werewolf);

//        var wolf = (Wolf)() -> System.out.println("howls");
//        noBoilerplate(wolf);
//
//        var human = (Human)() -> System.out.println("Hello");
//        noBoilerplate(human);

        noBoilerplate(new Werewolf());

        var wolf = (Wolf)() -> System.out.println("howls");
        System.out.println(isAlpha(wolf));

        var alphaWerewolf = (Alpha & Wolf)() -> System.out.println("Alpha howls");
        System.out.println(isAlpha(alphaWerewolf));
    }

    private static void boilerplate(HumanWolf werewolf){
        werewolf.howl();
        werewolf.talk();
    }

    private static <T extends Wolf & Human> void noBoilerplate(T werewolf){
        werewolf.howl();
        werewolf.talk();
    }

    private static class Werewolf implements Wolf, Human {
        @Override
        public void talk() {
            System.out.println("howls");
        }

        @Override
        public void howl() {
            System.out.println("talks");
        }
    }

    private static boolean isAlpha(Wolf wolf){
        return wolf instanceof Alpha; //Wolf and Alpha are not related.
    }
}

interface Human { //1
    void talk();
}

interface Wolf { //2
    void howl();
}

interface HumanWolf extends Wolf, Human {} //3

interface Alpha {}