package com.example.restservice.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralExeption extends RuntimeException {

    private GeneralResult generalResult;
}