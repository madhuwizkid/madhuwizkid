package com.test.address;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookProcessor {
    List<AddressBook> addressBooks = new ArrayList<>();
    int currentYear  = Integer.valueOf(DateTimeFormatter.ofPattern("yy").format( LocalDate.now()));
    public AddressBookProcessor(String filePath){
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            addressBooks = stream.map(line -> {
                String[] AddressDetails = line.split(",");
                return new AddressBook(formatString(AddressDetails[0]),
                                formatString(AddressDetails[1]),
                                getActualDataOfBirth(formatString(AddressDetails[2])));
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LocalDate getActualDataOfBirth(String inputDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate date = LocalDate.parse(inputDate, formatter);
        int year = Integer.valueOf(inputDate.substring(6,8));
        return LocalDate.of(year + (year >= (currentYear-80) ? 1900 : 2000),
                        date.getMonth(), date.getDayOfMonth());
    }

    private String formatString(String addressVal) {
        return addressVal != null ? addressVal.trim() : addressVal;
    }

    public long getNumMales() {
        return 1l;
    }

    public AddressBook getOldestPerson() {
        return new AddressBook("","",LocalDate.now());
    }


    public int getAgeDifference(String name1, String name2) {
        return 0;
    }


}
