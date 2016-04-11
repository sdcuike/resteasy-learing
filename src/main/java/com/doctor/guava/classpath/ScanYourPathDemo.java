package com.doctor.guava.classpath;

import java.util.Set;

import javax.ws.rs.Path;

import br.com.geraldoferraz.scanyourpath.Scanner;
import br.com.geraldoferraz.scanyourpath.searches.filters.arguments.SearchArguments;

/**
 * @author sdcuike
 *
 *         Create At 2016年4月11日 下午6:32:52
 */
public class ScanYourPathDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        Set<Class<?>> anyWhere = scanner.allClasses(SearchArguments.annotatedWith(Path.class)).anyWhere();
        anyWhere.stream().forEach(System.out::println);

    }

}
