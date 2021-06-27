package basics.p2_extension_functions.v_5_vararg_infix_libs

data class User(val id: Int,val name: String,val address: String)
fun saveUser_v1(user: User){
    if (user.name.isEmpty()){
        throw IllegalArgumentException("bad user, ${user.id} empty field 'name'")
    }

    if (user.address.isEmpty()){
        throw IllegalArgumentException("bad user, ${user.id} empty field 'address'")
    }
    //save the user
}

fun saveUser_v2(user: User){
    fun validate(user:User, value: String, field: String){
        // this is cleaner since there is no reason to have another func in the package / class
        if (value.isEmpty()){
            throw throw IllegalArgumentException("bad user ${user.id}, empty field $field")
        }
    }
    validate(user,user.name,"Name")
    validate(user,user.address,"Address")
    //save the user
}


fun saveUser_v3(user: User){
    fun validate(value: String, field: String){
        // even cleaner
        if (value.isEmpty()){
            throw throw IllegalArgumentException("bad user ${user.id}, empty field $field")
        }
    }
    validate(user.name,"Name")
    validate(user.address,"Address")
    //save the user
}


// final version

// this is not relevant to any other places where User is used.
// instead of making the user more complex and adding it another method
// that will be used only in our package
// we extend it locally, and dont affect other clients
fun User.validateBeforeSave(){
    fun validate(value: String, field: String){
        // even cleaner
        if (value.isEmpty()){
            throw throw IllegalArgumentException("bad user ${this.id}, empty field $field")
        }
    }
    validate(name,"Name")
    validate(address,"Address")
}

fun saveUser(user: User){
    user.validateBeforeSave()
    //do the save
}