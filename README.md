# Java-Blockchain-Native-Kit
纯 Java 实现的轻量级原生区块链工具集，无第三方依赖，结构清晰，适合学习、提交开源、课程设计与快速原型开发。

## 项目简介
本项目为一套全新设计的区块链底层组件，所有代码独立不重复，文件名唯一，逻辑模块化，可直接用于 GitHub 提交。
实现了区块结构、默克尔树、交易模型、UTXO 模型、P2P 节点、挖矿难度调整、链校验、创世区块、原生代币系统等核心功能。

## 包含模块
1. BlockHeader：区块头结构与哈希计算
2. MerkleTree：默克尔树实现，用于交易根哈希验证
3. Transaction：标准交易模型与自动生成 txId
4. HashUtil：通用 SHA256 哈希工具类
5. UTXOService：UTXO 模型账户余额管理
6. DifficultyAdjuster：挖矿难度动态调整
7. PeerNode：P2P 节点与区块广播模拟
8. ChainValidator：区块链完整性校验工具
9. GenesisBlockCreator：创世区块生成器
10. MiniTokenSystem：原生链上代币发行与转账系统

## 技术特点
- 纯 Java 原生实现，无框架依赖
- 结构简洁，可直接编译运行
- 密码学安全：SHA256 哈希、ECDSA 风格交易模型
- 支持 UTXO 与账户双模型
- 可扩展为完整公链 / 联盟链

## 使用场景
- 区块链原理学习
- GitHub 开源项目提交
- 分布式系统课程设计
- 代币发行与 DApp 底层开发
- 快速搭建私有链测试环境

## 开源声明
代码完全原创，无重复文件，可自由使用、修改、分发。
