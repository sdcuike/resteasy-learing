package com.doctor.guava.classpath;

import java.util.Set;

import javax.ws.rs.Path;

import br.com.geraldoferraz.scanyourpath.Scanner;
import br.com.geraldoferraz.scanyourpath.searches.filters.arguments.SearchArguments;
import br.com.geraldoferraz.scanyourpath.searches.loaders.ClassPathLoaderTypes;

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
        System.out.println("scan:");
        Scanner scanner = new Scanner();
        scanner.limitSearchingPathTo(ClassPathLoaderTypes.full());
        Set<Class<?>> anyWhere = scanner.allClasses(SearchArguments.annotatedWith(Path.class)).anyWhere();
        anyWhere.stream().forEach(System.out::println);

    }

}
