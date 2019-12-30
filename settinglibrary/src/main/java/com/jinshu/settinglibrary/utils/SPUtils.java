package com.jinshu.settinglibrary.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * 对SharedPreference文件中的各种类型的数据进行存取操作
 */
public class SPUtils {

    private static SharedPreferences sp;

    private static void init() {
        if (sp == null) {
            sp = PreferenceManager.getDefaultSharedPreferences(SDKUtils.getAppContext());
        }
    }

    public static void setSharedIntData(String key, int value) {
        if (sp == null) {
            init();
        }
        sp.edit().putInt(key, value).commit();
    }

    public static int getSharedIntData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getInt(key, 0);
    }

    public static void setSharedlongData(String key, long value) {
        if (sp == null) {
            init();
        }
        sp.edit().putLong(key, value).commit();
    }

    public static long getSharedlongData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getLong(key, 0l);
    }

    public static void setSharedFloatData(String key, float value) {
        if (sp == null) {
            init();
        }
        sp.edit().putFloat(key, value).commit();
    }

    public static Float getSharedFloatData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getFloat(key, 0f);
    }

    public static void setSharedBooleanData(String key, boolean value) {
        if (sp == null) {
            init();
        }
        sp.edit().putBoolean(key, value).commit();
    }

    public static Boolean getSharedBooleanData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getBoolean(key, true);
    }

    public static void setSharedStringData(String key, String value) {
        if (sp == null) {
            init();
        }
        sp.edit().putString(key, value).commit();
    }

    public static String getSharedStringData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getString(key, "");
    }

    /**
     * 存放实体类以及任意类型
     *
     * @param key
     * @param obj
     */
    public static void putBean(String key, Object obj) {
        if (obj instanceof Serializable) {// obj必须实现Serializable接口，否则会出问题
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(obj);
                String string64 = new String(Base64.encode(baos.toByteArray(),
                        0));
                if (sp == null) {
                    init();
                }
                sp.edit().putString(key, string64).commit();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            throw new IllegalArgumentException(
                    "the obj must implement Serializble");
        }

    }

    public static Object getBean(String key) {
        Object obj = null;
        try {
            if (sp == null) {
                init();
            }
            String base64 = sp.getString(key, "");
            if (base64.equals("")) {
                return null;
            }
            byte[] base64Bytes = Base64.decode(base64.getBytes(), 1);
            ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static void remove(String k) {
        if (sp == null) {
            init();
        }
        sp.edit().remove(k).commit();
    }

}