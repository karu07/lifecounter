package com.gamelot.lifecounter.user.service.utils.exceptions

class EmailAlreadyInUseException(email: String) : Exception("El email $email ya se encuentra en uso")