package com.lasam.demo.sometests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuhao
 * @date 2020/5/23 21:51
 */
@Slf4j
public class MapTest {

    @Test
    public void 扩容() throws NoSuchFieldException, IllegalAccessException {
        Map<Integer, Integer> m = new HashMap<>();
        log.info("map size:{}, table size:{}", m.size(), getTableSize(m));

        for (int i = 0; i < 16; i++) {
            m.put(i, i);
            log.info("map size:{}, table size:{}", m.size(), getTableSize(m));
        }
    }

    @Test
    public void 扩容_ex1() throws NoSuchFieldException, IllegalAccessException {
        Map<SameHash, Integer> m = new HashMap<>();

        log.info("map size:{}, table size:{}", m.size(), getTableSize(m));

        for (int i = 0; i < 16; i++) {
            m.put(new SameHash(), i);
            log.info("map size:{}, table size:{}", m.size(), getTableSize(m));
        }
    }

    @Test
    public void 桶树互转() throws NoSuchFieldException, IllegalAccessException {
        Map<SameHash, Integer> m = new HashMap<>(64);

        for (int i = 0; i < 8; i++) {
            m.put(new SameHash(), i);
        }

        log.info("map size:{}, table class:{}", m.size(), getTableClass(m));
        m.put(new SameHash(), 8);

        log.info("map size:{}, table class:{}", m.size(), getTableClass(m));


    }

    private String getTableClass(Map<?, ?> m) throws NoSuchFieldException, IllegalAccessException {
        Field tableF = HashMap.class.getDeclaredField("table");
        tableF.setAccessible(true);

        Object[] table = (Object[]) tableF.get(m);
        if (table == null) {
            return null;
        }
        Object o = table[0];
        return table.getClass().getSimpleName();
    }

    private Integer getTableSize(Map<?, ?> m) throws NoSuchFieldException, IllegalAccessException {
        Field tableF = HashMap.class.getDeclaredField("table");
        tableF.setAccessible(true);

        Object[] table = (Object[]) tableF.get(m);
        if (table == null) {
            return null;
        }
        return table.length;
    }

    private static class SameHash {
        @Override
        public int hashCode() {
            return 1;
        }
    }

}
