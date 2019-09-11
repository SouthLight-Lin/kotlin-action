package action.ch04._04;

/**
 * Java实现View
 *
 * Created by linnanwei on 2019/9/10
 *
 * @author linnanwei
 */
// public class Button implements View {
//     @Override
//     public State getCurrentState() {
//         return new ButtonState();
//     }
//
//     @Override
//     public void restoreState(final State state) {
//
//     }
//
//     /**
//      * 如果去序列化时，会发生NotSerializableException异常
//      * 原因是该类是Button的内部类，ButtonState类隐式保存了
//      * 它外部Button类的应用，而Button不能被序列化
//      * 解决办法就是将ButtonState类声明为static
//      * */
//     public static class ButtonState implements State{
//
//     }
// }
