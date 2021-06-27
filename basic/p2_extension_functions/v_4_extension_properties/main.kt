package basics.p2_extension_functions.v_4_extension_properties

// never used it in my life
var StringBuilder.lastChar: Char // todo: try changing var to val
    get() = get(length - 1)
    set(v: Char)  {
        setCharAt(length-1,v)
    }
