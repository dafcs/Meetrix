package com.Meetrix.other;

import com.Meetrix.models.Event;
import com.Meetrix.models.Member;
import com.Meetrix.models.Venue;
import com.Meetrix.models.enums.DietaryRequirement;
import com.Meetrix.models.enums.PriceRange;
import com.Meetrix.models.enums.VenueType;
import com.Meetrix.repositories.EventRepository;
import com.Meetrix.repositories.MemberRepository;
import com.Meetrix.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    EventRepository eventRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        eventRepository.deleteAll();
        memberRepository.deleteAll();
        venueRepository.deleteAll();

        List<DietaryRequirement> dietaryRequirements = new ArrayList<>();
        dietaryRequirements.add(DietaryRequirement.VEGAN);
        dietaryRequirements.add(DietaryRequirement.GLUTENFREE);

        LocalDate dob = LocalDate.of(2002,03,2);
        Member member1 = new Member("Iris","iris@email.com",dob,dietaryRequirements);

        Member member2 = new Member("Toby","toby@email.com",dob,dietaryRequirements);

        memberRepository.save(member1);
        memberRepository.save(member2);

        Venue venue1 = new Venue("Danny's", VenueType.STRIPCLUB, dietaryRequirements, 50, 18, PriceRange.HIGH);

        venueRepository.save(venue1);

        Event event1 = new Event("Alex's stag do", member2);

        event1.addMember(member1);

        eventRepository.save(event1);



    }

}
