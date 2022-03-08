package coreapi.sid.command.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.commands.CreateCustomerCommand;
import org.sid.coreapi.events.CreateCustomerEvent;

@Aggregate
@Slf4j
public class CustomerAggregate {
    @AggregateIdentifier
    private String customerId;
    private String name;
    private String email;

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {
        log.info("CreateCustomerEvent recieved");
        AggregateLifecycle.apply(new CreateCustomerEvent(
                command.getId(),
                command.getName(),
                command.getEmail()
        ));
    }

    @EventSourcingHandler
    public void on(CreateCustomerEvent event){
        log.info("CreateCustomerEvent occured");
        this.customerId=event.getId();
        this.name=event.getName();
        this.email=event.getEmail();
    }


}
