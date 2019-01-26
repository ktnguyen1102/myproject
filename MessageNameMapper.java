/* package com.msgServ.springboot.ua_project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MessageNameMapper {
	MessageNameMapper INSTANCE = Mappers.getMapper( MessageNameMapper.class );
    @Mapping(target = "text", source = "text")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "timeout", source = "timeout")
    
    MessageNameResponse map(MessageInfo messageInfo);

    default Page<MessageNameResponse> map(Page<MessageInfo> page) {
       return page.map(this::map);
   }

    default List<MessageNameResponse> map(List<MessageInfo> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}
*/
