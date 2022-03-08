package org.sid.coreapi.events

import org.axonframework.modelling.command.TargetAggregateIdentifier
import org.sid.coreapi.commands.BaseCommand

abstract class BaseEvent<T> (

    open val id:T
)

data class CreateCustomerEvent(
        override val id : String,
        val name:String,
        val email : String
) : BaseEvent<String>(id)

data class UpdateCustomerEvent(
        override val id : String,
        val name:String,
        val email : String
) : BaseEvent<String>(id)