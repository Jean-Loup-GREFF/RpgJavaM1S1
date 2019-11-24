/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

/**
 *
 * @author Matthieu
 */
public class KeyPressing {
    private static boolean aPress = false;
    private static boolean zPress = false;
    private static boolean ePress = false;
    private static boolean rPress = false;
    private static boolean tPress = false;
    public static boolean isAPress() {
        synchronized (KeyPressing.class) {
            return aPress;
        }
    }
    public static boolean isZPress() {
        synchronized (KeyPressing.class) {
            return zPress;
        }
    }
    public static boolean isEPress() {
        synchronized (KeyPressing.class) {
            return ePress;
        }
    }
    public static boolean isRPress() {
        synchronized (KeyPressing.class) {
            return rPress;
        }
    }
    public static boolean isTPress() {
        synchronized (KeyPressing.class) {
            return tPress;
        }
    }

    public static void main(String[] args) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (KeyPressing.class) {
                    switch (ke.getID()) {
                        case KeyEvent.KEY_PRESSED:
                        switch(ke.getKeyCode()){
                            case KeyEvent.VK_A:
                                aPress = true;
                                break;
                            case KeyEvent.VK_Z:
                                zPress = true;
                                break;
                            case KeyEvent.VK_E:
                                ePress = true;
                                break;
                            case KeyEvent.VK_R:
                                rPress = true;
                                break;
                            case KeyEvent.VK_T:
                                tPress = true;
                                break;
                        }
                        break;
                        case KeyEvent.KEY_RELEASED:
                            switch(ke.getKeyCode()){
                                case KeyEvent.VK_A:
                                    aPress = false;
                                    break;
                                case KeyEvent.VK_Z:
                                    zPress = false;
                                    break;
                                case KeyEvent.VK_E:
                                    ePress = false;
                                    break;
                                case KeyEvent.VK_R:
                                    rPress = false;
                                    break;
                                case KeyEvent.VK_T:
                                    tPress = false;
                                    break;
                            }
                            break;
                    }
                }
                return false;
            }    
        });
    }
}