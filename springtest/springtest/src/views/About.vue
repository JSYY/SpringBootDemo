<template>
    <div class="FlexRow">
        <button class="rank" @click="SendIdAndName">SendIdAndName</button>
        <button class="rank" @click="SendJsonData">SendJsonData</button>
        <button class="rank" @click="SendProtobufData">SendProtobufData</button>
        <button class="rank" @click="GetPersonList">GetPersonList</button>
    </div>
    <div class="FlexRow">
        <div>
            <div>id</div>
            <input v-model="pid">
        </div>
        <div>
            <div>name</div>
            <input v-model="pname">
        </div>
        <button class="rank" @click="AddPerson">AddPerson</button>
    </div>
    <div>
        <div v-for="(item,i) in personList">
            <div class="FlexRow">
                <div>{{i+1}}--{{item.id}}--{{item.name}}</div>
                <button @click="Delete(item)">Delete</button>
                <button @click="Edit(item.id,item.name)">Edit</button>
            </div>
        </div>
    </div>
<!-- 编辑页面 -->
    <div v-show="showEditPage">
        <EditPage :id="editid" :name="editname" @closeEditpage="CloseEditpage"></EditPage>
    </div>

</template>

<script lang="ts">
    import axios from 'axios';
    import { Person } from "../../public/protobuffer/main.proto";
    import ParseprotobufService  from "../service/parse-protobuf.service";
    import { getCurrentInstance, onMounted, ref } from 'vue';
    import DialogService from '../../src/components/dialog/dialog.service';
    import EditPage from '../../src/components/edit.vue';
    import ENS from '../service/event-notify.service';

    export default {
        components:{
            EditPage
        },
        setup() {
            let personList = ref();
            let pid=ref();
            let pname=ref();
            let editid=ref();
            let editname=ref();
            let showEditPage=ref(false);
            let ins = getCurrentInstance();
            
            //引用类型需要使用ref映射到html
            //数值类型不需要ref

            //待修改  id与 name在前端创建person类统一管理

            ENS.onEvent("updatePersonList").subscribe(()=>{
                //收到其他组件发来消息，通知更新列表
                GetPersonList();
            });

            onMounted(()=>{
                GetPersonList();
            });

            function SendIdAndName() {
                axios.get("/sendIdAndName/{123}?name=lujiawei");
            }

            function SendJsonData() {
                let data = { "id": "123", "name": "lujiawei" };
                axios.post("/sendJsonData", data);
            }

            function SendProtobufData() {
                let p = new Person();
                p.id = "1";
                p.name = "ljw";
                let s = ParseprotobufService.Encode(Person, p);
                const para = new FormData();
                para.set('data', s);
                para.set('type', "protobuf");
                axios.post("/getPostRequest", para).then((res) => {
                    //反序列化protobuf 
                    let v = ParseprotobufService.Decode(res.data);s
                    let np = Person.decode(v);
                    console.log(np);
                });
            }

            function GetPersonList() {
                axios.get("/TestApi/personList").then(res => {
                    console.log(res.data);
                    personList.value=res.data;
                    console.log(personList);
                });
            }

            function Delete(person:any){
                axios.post("/TestApi/deletePerson",person).then((res)=>{
                    if(res.data == 1){
                        GetPersonList();
                    }
                });
            }

            function AddPerson(){
                let person = {"id":pid.value,"name":pname.value};
                console.log(person);
                axios.post("/TestApi/addPerson",person).then((res)=>{
                    if(res.data == 1){
                        GetPersonList();
                        ClearInputMessage();
                    }
                });
            }

            function ClearInputMessage(){
                pid.value="";
                pname.value="";
            }

            function Edit(id:String,name:String){
                //待开发--动态渲染组件
                //DialogService.AddDialogComponent(ins,EditPage,"editMain",{id:pid,name:pname});
                editid.value=id;
                editname.value=name;
                showEditPage.value=true;
            }

            function CloseEditpage(){
                showEditPage.value=false;
            }

            return {
                SendIdAndName,
                SendJsonData,
                SendProtobufData,
                GetPersonList,
                personList,
                Delete,
                AddPerson,
                pid,
                pname,
                showEditPage,
                Edit,
                editid,
                editname,
                CloseEditpage
            }
        }
    }

</script>

<style scoped>
    .FlexCol{
        display:flex;
        flex-direction:column;
    }
    .FlexRow{
        display:flex;
        flex-direction:row;
    }
    .rank{
        margin:10px;
        height:30px;
        width:120px;
        border-radius:4px;
        text-align:center;
        font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    }
    .editPage{
        position:absolute;

    }
</style>
