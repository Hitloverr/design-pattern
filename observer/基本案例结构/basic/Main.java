package basic;

public class Main {
    public static void main(String[] args) {
        Observer observer1 = new Observer() {
            @Override
            public void update(Message message) {
                System.out.println(message);
            }
        };

        Observer observer2 = new Observer() {
            @Override
            public void update(Message message) {
                System.out.println(message);
            }
        };

        ConcreteObservable concreteObservable = new ConcreteObservable();
        concreteObservable.addObserver(observer1);
        concreteObservable.addObserver(observer2);
        concreteObservable.notifyObservers(new Message());
    }
}
