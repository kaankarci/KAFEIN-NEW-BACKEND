package com.example.restservice.controller;

import com.example.restservice.model.dto.HisseDto;
import com.example.restservice.service.HisseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hisse")
@Api(tags = "Hisse Information")
public class HisseController {

    @Autowired
    private final HisseService hisseService;

    public HisseController(HisseService hisseService) {
        this.hisseService = hisseService;
    }

    @ApiOperation(value = "Save Hisse")
    @PostMapping(path = "/save-hisse")
    public ResponseEntity<HisseDto> createHisse(@RequestBody HisseDto hisseDto){
        return new ResponseEntity(hisseService.createHisse(hisseDto), HttpStatus.OK);
    }

    @ApiOperation(value = "All hisse")
    @GetMapping(path = "/all-hisse")
    public ResponseEntity<HisseDto> getAllHisse(){
        return new ResponseEntity(hisseService.getAllHisse(),HttpStatus.OK);
    }

    @ApiOperation(value = "Get Hisse By hisseId")
    @GetMapping(path = "/{hisseId}")
    public ResponseEntity<HisseDto> getHisseByHisseId(@PathVariable(name = "hisseId")Long hisseId){
        return  new ResponseEntity(hisseService.getHisseByHisseId(hisseId),HttpStatus.OK);
    }
}
