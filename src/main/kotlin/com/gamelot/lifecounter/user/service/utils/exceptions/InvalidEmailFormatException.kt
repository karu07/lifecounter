package com.gamelot.lifecounter.user.service.utils.exceptions

class InvalidEmailFormatException (email: String) : Exception("El email $email no tiene un formato válido")
