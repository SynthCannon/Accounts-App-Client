package com.angular.application;

import lombok.*;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @Size(min = 1, max = 40) String firstName;
    private @Size(min = 1, max = 40) String secondName;
    private @NonNull String accountNumber;

    private static int accNum = 313;

    public Account(String firstName, String secondName) {
        accNum++;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountNumber = Integer.toString(accNum);
    }

    public static int getNextAccNum(){
        return ++accNum;
    }
}