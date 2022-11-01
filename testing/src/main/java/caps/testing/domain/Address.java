package caps.testing.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Address {

    private String city;
    private String street;

    protected Address(){

    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
