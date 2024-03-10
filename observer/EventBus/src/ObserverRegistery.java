import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;


public class ObserverRegistery {
    // key是消息的类，value是消息对应的观察者。
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registery = new ConcurrentHashMap<>();

    // 一个消息对应的观察者有哪些
    // 消息类型 --> 接受它的观察者类 和 对应的方法

    // 注册观察者

    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> allObserverActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : allObserverActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registedActions = registery.get(eventType);
            if (registedActions == null) {
                registery.putIfAbsent(eventType,new CopyOnWriteArraySet<>());

            }
        }
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>,Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        for (Method method : getAnnotationMethos(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType,new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer,method));
        }
        return observerActions;
    }

    // 得到clazz这个类中表明了注解的方法

    private List<Method> getAnnotationMethos(Class<?> clazz) {
        List<Method> methods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                methods.add(method);
            }
        }
        return methods;
    }
}
